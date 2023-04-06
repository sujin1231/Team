package com.tp.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tp.DTO.BoardDTO;
import com.tp.entity.Board;
import com.tp.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
	public class BoardService {
	
		private final BoardRepository boardRepository;
		
		@Transactional
		public void save(Board board, MultipartFile file) throws Exception{
			
			if(!file.isEmpty()) {
				String projectPath = System.getProperty("user.dir") +"\\src\\main\\webapp\\resources\\files";
				
				UUID uuid = UUID.randomUUID();
				
				String fileName = uuid +"_"+ file.getOriginalFilename();
				
				File savefile = new File(projectPath, fileName);
				
				file.transferTo(savefile);
				
				board.setFilename(fileName);
				board.setFilepath("/resources/files/" +fileName);
				
			}else {
				board.setFilename("");
		        board.setFilepath("");
			}
			
			boardRepository.save(board);
		}
	
	@Transactional
	public List<Board> Content() {
		
		List<Board> boardlist = boardRepository.findAll();
		List<BoardDTO> boarddtolist = new ArrayList<>();
		
		for(Board board : boardlist) {
			BoardDTO boardDTO = BoardDTO.builder()
					.num(board.getNum())
					.content(board.getContent())
					.genre(board.getGenre())
					.hit(board.getHit())
					.regdate(board.getRegdate())
					.title(board.getTitle())
					.writer(board.getWriter())
					.build();
			boarddtolist.add(boardDTO);
		}
		
		return boardlist;
	}
	
	@Transactional
	public BoardDTO selectOne(Long num) {
		Optional<Board> board = boardRepository.findById(num);
		
		Board board1 = board.get();
		
		BoardDTO dto = BoardDTO.builder()
				.num(board1.getNum())
				.content(board1.getContent())
				.genre(board1.getGenre())
				.hit(board1.getHit())
				.regdate(board1.getRegdate())
				.title(board1.getTitle())
				.writer(board1.getWriter())
				.filename(board1.getFilename())
				.filepath(board1.getFilepath())
				.build();
//			return boardRepository.findById(num).orElseThrow(() -> new IllegalArgumentException("출력 X"));
		return dto;
	}
	
	//삭제
	@Transactional
	public void delete(Long num) {
		boardRepository.deleteById(num);
	}
	
	// 페이징
//	@Transactional
//	public Page<Board> page(Pageable pageable) {
//		return boardRepository.findAll(pageable);
//	}
	
//	
	public Page<Board> list(int page) {
		return boardRepository.findAll(PageRequest.of(page, 3, Sort.by(Sort.Direction.DESC, "num")));
	}


	
	
}
