package com.byh.orderonline.dao;

import com.byh.orderonline.pojo.Review;
import com.byh.orderonline.pojo.ReviewExample;
import java.util.List;

public interface ReviewMapper extends CrudDao<Review>{

    List<Review> selectByExample(ReviewExample example);

}