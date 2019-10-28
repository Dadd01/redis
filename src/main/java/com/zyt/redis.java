package com.zyt;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class redis {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        Post post=new Post();
        post.setTitle("zyt");
        post.setContent("book");
        post.setAnthor("hello");
        Long postId=savePost1(post,jedis);
        System.out.println("保存成功");
        Post post1=getPost(postId,jedis);
        System.out.println(post1);
        del(jedis,postId);   //删
        update(jedis,postId);//改

    }

//    public static Long savePost(Post post, Jedis jedis) {
//        Long posts = jedis.incr("posts");
//        String postStr = JSON.toJSONString(post);
//        jedis.set("post:" + posts + "data:",postStr);
//        return posts;
//    }
//    public static Post getPost(Jedis jedis, Long postId) {
//        String post=jedis.get("post:"+postId+":data");
//        Post post1=JSON.parseObject(post,Post.class);
//        return post1;
//    }
    public static Long savePost1(Post post, Jedis jedis) {
        Long postId = jedis.incr("post");
        Map<String,String> blog=new HashMap<String, String>();
        blog.put("title",post.getTitle());
        blog.put("author",post.getAnthor());
        blog.put("content",post.getContent());
        jedis.hmset("postId:"+postId+":data",blog);
        return postId;
    }
    static Post getPost(Long postId,Jedis jedis){
        Map<String,String> myblog=jedis.hgetAll("post:"+postId+":data");
        Post post=new Post();
        return post;
    }
    public static void del(Jedis jedis,Long postId){

        jedis.del("post"+postId+"data");
    }

    public static void update(Jedis jedis,Long postId){

        String postjson=jedis.get("post"+postId+"Data");
        Post post=JSON.parseObject(postjson,Post.class);
        post.setTitle("handsome");
        post.setContent("jake");
        String post1=JSON.toJSONString(postjson);
        jedis.set("post"+postId+"data",post1);
    }

}
