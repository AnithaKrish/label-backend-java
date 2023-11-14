package com.example.demo.service;

import com.example.demo.model.Label;
import com.example.demo.repository.LabelRepository;
import com.example.demo.util.AppUtil;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LabelService
{
   @Autowired
    LabelRepository labelRepository;

    public Label addLabel(Label label){
        return labelRepository.save(label);
    }

    public List<Label> getLabels() {
        List<Label> labelList = labelRepository.findAll();
        Map<String,List<Label>> map ;
        List<Label> hierarchyList = new ArrayList<>();
        map = AppUtil.groupChildren(labelList,hierarchyList);
        for(Label label:labelList)
            AppUtil.mapChildToParentLabel(label,map);
        return hierarchyList;
    }
}
