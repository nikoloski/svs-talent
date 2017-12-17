package com.nikoloski.entity.tweet;

import com.nikoloski.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TweetRepository extends CrudRepository<Tweet, Long> {

    Collection<Tweet> findByUser(User user);
}
