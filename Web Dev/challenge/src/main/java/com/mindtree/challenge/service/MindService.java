package com.mindtree.challenge.service;

import com.mindtree.challenge.entity.Mind;

public interface MindService {
	public Mind createMind(Mind mind);
	public Mind findMindById(int mid);
}
