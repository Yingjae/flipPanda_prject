package com.flippanda.collection.mapper;

import java.util.List;

import com.flippanda.vo.MyCollectionVO;

public interface CollectionMapper {

	// 전체글 목록 받아오는 메서드
	public List<MyCollectionVO> getAllCollectionList();
	
	// 특정 회원의 글 목록 받아오는 메서드
	public List<MyCollectionVO> usersCollectionList(long userNum);
	
	// 글을 추가하는 메서드
	public void insertMyCollection(MyCollectionVO cVO);
	
	// 글을 삭제하는 메서드
	public void deleteMyCollection(long collectionNum);
	
	// 글 수정을 위해 collectionNum번글 조회하는 메서드
	public MyCollectionVO selectMyCollection(long collectionNum);
	
	// 글을 수정하는 메서드
	public void updateMyCollection(MyCollectionVO cVO);
	

}
