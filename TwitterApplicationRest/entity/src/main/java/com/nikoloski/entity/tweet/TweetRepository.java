package com.nikoloski.entity.tweet;

import com.nikoloski.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TweetRepository extends CrudRepository<Tweet, Long> {

    List<Tweet> findByUser(User user);
}
