package com.flippanda.collection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flippanda.collection.mapper.CollectionMapper;
import com.flippanda.vo.MyCollectionVO;

@Service
public class CollectionServiceImpl implements CollectionService {

	// DAO호출을 위한 선언과 의존성 주입
	@Autowired
	private CollectionMapper collectionMapper;

	@Override
	public List<MyCollectionVO> getAllCollectionList() {
		return collectionMapper.getAllCollectionList();
	}

	@Override
	public List<MyCollectionVO> usersCollectionList(long userNum) {
		return collectionMapper.usersCollectionList(userNum);
	}

	@Override
	public void insertMyCollection(MyCollectionVO cVO) {
		collectionMapper.insertMyCollection(cVO);
	}

	@Override
	public void deleteMyCollection(long collectionNum) {
		collectionMapper.deleteMyCollection(collectionNum);
	}

	@Override
	public MyCollectionVO selectMyCollection(long collectionNum) {
		return collectionMapper.selectMyCollection(collectionNum);
	}

	@Override
	public void updateMyCollection(MyCollectionVO cVO) {
		collectionMapper.updateMyCollection(cVO);
	}
	
}
