package com.flippanda.collection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flippanda.collection.mapper.CollectionAttachMapper;
import com.flippanda.collection.mapper.CollectionMapper;
import com.flippanda.vo.CollectionAttachVO;
import com.flippanda.vo.MyCollectionVO;
import com.flippanda.vo.clikeVO;

@Service

public class CollectionServiceImpl implements CollectionService {

	// DAO호출을 위한 선언과 의존성 주입
	@Autowired
	private CollectionMapper collectionMapper;

	@Autowired
	private CollectionAttachMapper attachMapper;
	
	@Override
	public List<MyCollectionVO> getAllCollectionList() {
		return collectionMapper.getAllCollectionList();
	}

	@Override
	public List<MyCollectionVO> usersCollectionList(long userNum) {
		return collectionMapper.usersCollectionList(userNum);
	}

	@Transactional
	@Override
	public void insertMyCollection(MyCollectionVO cVO) {
		collectionMapper.insertMyCollection(cVO);
		
		if(cVO.getAttachList() == null || cVO.getAttachList().size() <= 0) {
			return;
		}
		
		cVO.getAttachList().forEach(attach ->{
			attach.setCollectionNum(cVO.getCollectionNum());
			attachMapper.insert(attach);
		});
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

	@Override
	public List<CollectionAttachVO> getAttachList(long collectionNum){
		return attachMapper.findByCollectionNum(collectionNum);
	}
}
