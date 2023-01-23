package com.api.sdk.okta.oktaSDK.dto.group;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class People {
	
	private PeopleUsers users;
	private PeopleUsers groups;

}
