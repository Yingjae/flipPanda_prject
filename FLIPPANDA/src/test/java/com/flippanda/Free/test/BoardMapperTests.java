package com.flippanda.Free.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flippanda.vo.FreeCriteria;
import com.flippanda.Free.mapper.FreeBoardMapper;
import com.flippanda.vo.FreeBoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	
	@Autowired
	private FreeBoardMapper FreeboardMapper;
	
	// 테스트용 메서드의 이름은 testGetList입니다.
	// 테스트 코드가 실행될 수 있도록 작성해주세요.
	//@Test
	public void testGetList() {
	//	List<FreeBoardVO> result= FreeboardMapper.getList();
	//	log.info("저장된 게시물 정보 : " + result);
	}
	
	
	//@Test
	public void testInsert() {
		//vo를 입력받는 insert 메서드 특성상
		// title, content, writer가 채워진 vo를 먼저 생성해야 합니다.
		FreeBoardVO vo = new FreeBoardVO();
		log.info("채워넣기 전 : " + vo);
		
		vo.setFreeBoardTitle("테스트로입력받는제목");
		vo.setFreeBoardContent("테스트로입력받는본문");
		//vo.set("테스트글쓴이");
		
		log.info("채워넣은 후 : " + vo);
		// vo내부에 데이터가 바인딩된걸 확인했으니 메서드 호출
		FreeboardMapper.insert(vo);
	}
	
	// select 메서드에 대한 테스트 코드 작성
	//@Test
	public void getSelect() {
		// 가져오기(글번호는 두 번째로 큰 번호로 해주세요.)
		FreeBoardVO vo = FreeboardMapper.select(103);
		// 로그 찍기
		log.info(vo);
	}
	
	// delete 메서드에 대한 테스트 코드 작성 후
	// 삭제여부 sqldevloper나 상단의 getAllList()로 확인해보세요.
	//@Test
	public void delete() {
		FreeboardMapper.delete(104);
	}
	
	// update 메서드에 대한 테스트 코드를 작성해주신 다음
	// 수정여부를 getAllList()로 확인해보세요.
	//@Test
	public void testUpdate() {
		FreeBoardVO freeboard = new FreeBoardVO();
		log.info("전달 데이터 아직 입력 안된 vo : " + freeboard);
		// setter로 전달할 title, content, bno를 채워주세요.
		freeboard.setFreeBoardTitle("바꿀제목");
		freeboard.setFreeBoardContent("바꿀본문");
		freeboard.setFreeBoardNum(41);
		log.info("전달 데이터가 입력된 vo : " + freeboard);
		// 실행
		FreeboardMapper.update(freeboard);
	}
	
	@Test
	public void testUpdate2() {
		FreeboardMapper.update2("up2로 바꾼제목", "up2로 바꾼본문", 42);
	}
	
	// 구문 생성이 어떻게되는지 관측하기 위한 테스트코드
	// 검색어 검색조건 실행 제대로 되는지 여부 테스트
	//@Test
//	public void testSearchGetList() {
//		SearchCriteria cri = new SearchCriteria();
//		cri.setKeyword("asd");
//		cri.setSearchType("t");
		
//		FreeboardMapper.getList();
//	}
}
