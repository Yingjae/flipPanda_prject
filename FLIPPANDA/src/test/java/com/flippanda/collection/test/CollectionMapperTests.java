package com.flippanda.collection.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flippanda.collection.mapper.CollectionMapper;
import com.flippanda.vo.MyCollectionVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CollectionMapperTests {

	@Autowired
	private CollectionMapper collectionMapper;
	
	// 전체 컬렉션글 호출 테스트
	//@Test
	public void testgetAllCollectionList() {
		log.info(collectionMapper.getAllCollectionList());
	}
	
	// 특정 회원의 컬렉션글 호출 테스트
	//@Test
	public void testselectUsers() {
		log.info(collectionMapper.usersCollectionList(1));
	}
	
	// 글 추가하기 테스트
	//@Test
	public void testinsertMyCollection() {
		MyCollectionVO cVO = new MyCollectionVO();
		log.info("채워넣기 전 : " + cVO);
		cVO.setUserNum(2);
		cVO.setCollectionTitle("구찌");
		cVO.setCollectionContent("구찌 카드지갑 삼");
		
		log.info("채워넣은 후 : " + cVO);
		
		// cVO 내부에 데이터 바인딩 확인 했으니 추가 메서드를 호출해서 데이터 적재
		collectionMapper.insertMyCollection(cVO);	
	}
	
	// 글 삭제하기 테스트
	//@Test
	public void testdeleteMyCollection() {
		collectionMapper.deleteMyCollection(88);
	}
	
	// 글 수정하기 테스트
	@Test
	public void testupdateMyCollection() {
		MyCollectionVO cVO = new MyCollectionVO();
		log.info("전달 데이터가 입력 안된 cVO : " + cVO);
		cVO.setCollectionTitle("스와로브스키로 수정된 제목1");
		cVO.setCollectionContent("스와로브스키 목걸이 삼으로 수정1");
		cVO.setCollectionNum(99);
		log.info("전달 데이터가 입력 된 cVO : " + cVO);
		collectionMapper.updateMyCollection(cVO);
	}
}
