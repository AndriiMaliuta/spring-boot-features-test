package com.anma.bh.sb.springtesting.core.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.RepresentationModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post extends RepresentationModel<Post> {
    public int id;
    public int userId;
    public String title;
    public String body;

}
