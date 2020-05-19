package com.capstore.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.app.models.CommonFeedback;


@Repository("CommonFeedbackRepository")
public interface CommonFeedbackRepository extends JpaRepository<CommonFeedback, Integer> {

	void deleteByUserId(int userId);

}