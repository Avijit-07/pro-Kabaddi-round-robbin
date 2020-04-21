package com.boot.examples.prokabaddi.api.common.dao;

import java.util.Map;

import com.boot.examples.prokabaddi.api.common.Team;

public interface TeamDao {

	//To get the team from team id
	Team get(int id);
	
	Map<Integer, Team> getAllTeams();
}
