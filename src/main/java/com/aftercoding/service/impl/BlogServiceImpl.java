package com.aftercoding.service.impl;

import com.aftercoding.entity.Blog;
import com.aftercoding.mapper.BlogMapper;
import com.aftercoding.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anonymous
 * @since 2022-09-08
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
