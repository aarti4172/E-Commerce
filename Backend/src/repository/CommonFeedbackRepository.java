package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.main.model.CommonFeedback;

@Repository("CommonFeedbackRepository")
public interface CommonFeedbackRepository extends JpaRepository<CommonFeedback, Integer> {

	void deleteByUserId(int userId);

}
