package co.mask.board.vo;

import java.sql.Date;

public class BoardVo {
	private int boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private Date boardDate;
	private int boardLock;
	private String boardValue;

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardLock() {
		return boardLock;
	}

	public void setBoardLock(int boardLock) {
		this.boardLock = boardLock;
	}

	public String getBoardValue() {
		return boardValue;
	}

	public void setBoardValue(String boardValue) {
		this.boardValue = boardValue;
	}
}
