package com.flippanda.collection.mapper;

import java.util.List;

import com.flippanda.vo.CollectionAttachVO;

public interface CollectionAttachMapper {

	public void insert(CollectionAttachVO vo);
	
	public void delete(String uuid);
	
	public List<CollectionAttachVO> findByCollectionNum(long collectionNum);
}
