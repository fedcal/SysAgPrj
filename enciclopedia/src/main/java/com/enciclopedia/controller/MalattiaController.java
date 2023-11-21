package com.enciclopedia.controller;

import com.enciclopedia.constants.WebContstants;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( WebContstants.REST_CONTEX_STRING +"/malattia")
@Validated
public class MalattiaController {
}
