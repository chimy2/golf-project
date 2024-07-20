package com.java.tennis.view;

import java.util.ArrayList;

import com.java.tennis.model.CharacterDTO;
import com.java.tennis.model.SkillDTO;
import com.java.tennis.service.LanguageService;
import com.java.tennis.service.SkillService;

public class GameView {
	
	private CharacterDTO dto;
	private SkillService skillService;
	private ArrayList<SkillDTO> skillList;
	private MainView mainView = new MainView();
	
	public GameView() {
		dto = new CharacterDTO();
		skillService = new SkillService();
		skillList = skillService.getSkill();
	}
	
	public void gameView(CharacterDTO dtoCharacter) {
		
		
		String skillName = dtoCharacter.getSkill().getName();
		String result = "";
		int skillCount = skillService.getSkillCount();
		result += mainView.addStringMargin("어떤 스킬을 사용하겠습니까?");
		result += mainView.getSeperatorThin();
		
		for(int i=0; i<skillCount; i++) {
			String temp = skillList.get(i).getName();
			result += (i + 1) + ". " + temp;
			if(skillName.equals(temp)) {
				result += "!";
			}
			result += "\r\n";
			
		}
		result += mainView.input();
		System.out.print(result);
	}
}

