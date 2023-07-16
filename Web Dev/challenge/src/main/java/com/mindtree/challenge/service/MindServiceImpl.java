package com.mindtree.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.challenge.entity.Mind;
import com.mindtree.challenge.repository.MindRepository;

@Service
public class MindServiceImpl implements MindService {
	@Autowired
	private MindRepository mindRepository;

	@Override
	public Mind createMind(Mind mind) {

		return mindRepository.save(mind);
	}

	@Override
	public Mind findMindById(int mid) {
		return mindRepository.findById(mid).orElse(null);
	}

}
