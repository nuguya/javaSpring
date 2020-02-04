package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		
		boardDAO.deleteBoard(vo);

		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�� �� ��ȸ ó��");
		
		model.addAttribute("board",boardDAO.getBoard(vo));
		
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
    public String getBoardList(@RequestParam(value="searchCondition",defaultValue="TITLE",required=false) String condition,
    		@RequestParam(value="searchKeyword",defaultValue="",required=false)String keyword,
    		BoardVO vo, BoardDAO boardDAO, Model model) {
    	System.out.println("�� ��� �˻� ó��");

        model.addAttribute("boardList",boardDAO.getBoardList(vo));
        System.out.println(condition);
        System.out.println(keyword);
        
        return "getBoardList.jsp";
    }
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo,BoardDAO boardDAO) {
		System.out.println("�� ��� ó��");
				
		boardDAO.insertBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		
		boardDAO.updateBoard(vo);
		
		return "redirect:getBoardList.do";
	}
}

