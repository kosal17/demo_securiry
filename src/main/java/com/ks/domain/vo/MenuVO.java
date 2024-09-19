package com.ks.domain.vo;

import cn.hutool.core.bean.BeanUtil;
import com.ks.domain.entity.SysMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuVO extends SysMenu {

    private List<MenuVO> children;

    public static List<MenuVO> getMenuVoList(List<SysMenu> menuList) {
        List<MenuVO> menuVOList = new ArrayList<>();
        List<SysMenu> parentMenu = menuList.stream().filter(item -> item.getParentId() == 0).toList();
        // 转换对象类型
        for (SysMenu menu : parentMenu) {
            MenuVO menuVO = new MenuVO();
            BeanUtil.copyProperties(menu,menuVO);
            menuVOList.add(menuVO);
        }
        // 循环1级路由，获取所有的子菜单
        for (MenuVO menuVO : menuVOList) {
            // 获取所有的子节点
            List<MenuVO> childrenList = buildTree(menuList, menuVO.getId());
            menuVO.setChildren(childrenList);
        }
        return menuVOList;
    }

    /**
     * 获取所有子节点，递归获取【如果是2级不需要递归了】
     */
    private static List<MenuVO> buildTree(List<SysMenu> allMenu, Long parentId) {
        List<MenuVO> childrenList = new ArrayList<>();
        // 遍历所有的数据
        for (SysMenu menu : allMenu) {
            // 判断menu的parentId是否与传进来的parentId相同
            if(menu.getParentId().equals(parentId)) {
                MenuVO routerVO = new MenuVO();
                BeanUtil.copyProperties(menu,routerVO);
                childrenList.add(routerVO);
            }
        }
        // 递归childrenList可能还有子节点
        for (MenuVO childrenItem : childrenList) {
            childrenItem.setChildren(buildTree(allMenu,childrenItem.getId()));
        }
        return childrenList;
    }
}
