package com.flippanda.collection.service;

import java.util.List;

import com.flippanda.vo.MyCollectionVO;
import com.flippanda.vo.clikeVO;

public interface CollectionService {
	
	// 전체 글 조회 서비스
	public List<MyCollectionVO> getAllCollectionList();

	// 특정 유저의 글을 조회하는 서비스
	public List<MyCollectionVO> usersCollectionList(long userNum);
	
	// 글을 추가하는 서비스
	public void insertMyCollection(MyCollectionVO cVO);
	
	// 글을 삭제하는 서비스
	public void deleteMyCollection(long collectionNum);
	
	// 글 수정을 위해 collectionNum번글 조회하는 서비스
	public MyCollectionVO selectMyCollection(long collectionNum);
		
	// 글을 수정하는 서비스
	public void updateMyCollection(MyCollectionVO cVO);
	

}
