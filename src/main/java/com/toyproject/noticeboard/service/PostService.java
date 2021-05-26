package com.toyproject.noticeboard.service;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.Post;
import com.toyproject.noticeboard.model.User;
import java.util.List;

public interface PostService {

  List<Post> getPostList();

  List<Post> getPostListInCategory(Board board);

  List<Post> getUserPost(User user);

  Post savePost(Post post);

  void deletePost(String id);
}
