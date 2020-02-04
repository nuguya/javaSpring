package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		
		return conditionMap;
	}
	
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("�� ���� ó��");
		
		boardService.deleteBoard(vo);

		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("�� �� ��ȸ ó��");
		model.addAttribute("board",boardService.getBoard(vo));
		
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
    public String getBoardList(@RequestParam(value="searchCondition",defaultValue="TITLE",required=false) String condition,
    		@RequestParam(value="searchKeyword",defaultValue="",required=false)String keyword,
    		BoardVO vo, Model model) {
    	System.out.println("�� ��� �˻� ó��");

        model.addAttribute("boardList",boardService.getBoardList(vo));
        System.out.println(condition);
        System.out.println(keyword);
        
        return "getBoardList.jsp";
    }
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("�� ��� ó��");
				
		boardService.insertBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("�� ���� ó��");
		
		boardService.updateBoard(vo);
		
		return "redirect:getBoardList.do";
	}
}

