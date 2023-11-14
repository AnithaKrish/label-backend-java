package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "Labels")
public class Label implements Serializable {

    @Id
    private String id;
    @Field
    private String name;
    @Field("parent_id")
    private String parentId;
    @Transient
    private List<Label> children;
}
