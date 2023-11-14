package com.example.demo.util;

import com.example.demo.model.Label;

import java.util.*;

public interface AppUtil {


    static void mapChildToParentLabel(Label label,Map<String, List<Label>> map){
         List<Label> children = map.get(label.getId());
         if(children == null)
         {
             label.setChildren(Collections.EMPTY_LIST);
             return;
         }
         else{
             label.setChildren(children);
             for(Label child:children)
                 mapChildToParentLabel(child,map);
         }
    }

    static Map<String, List<Label>> groupChildren(List<Label> labelList,List<Label> hierarchyList){
        Map<String, List<Label>> map = new HashMap<>();
        for(Label label:labelList){
             String parentId = label.getParentId();
             if(parentId == null)
                 hierarchyList.add(label);
             else
                 map.computeIfAbsent(label.getParentId(), k -> new ArrayList<>()).add(label);
         }
        return map;
    }
}
