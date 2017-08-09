package com.jeeqb.zblog.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jeeqb.zblog.vo.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class TagServiceTest {
	
	@Autowired
	private TagService tagService;

	@Test
	public void testLoadArticleByTag() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTagCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTagById() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadTagList() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveTag() {
		Tag tag = new Tag();
		tag.setAliasName("测试");
		tag.setTagName("测试");
		tagService.saveTag(tag);
	}

	@Test
	public void testCheckExist() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTag() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTagList() {
		fail("Not yet implemented");
	}

	@Test
	public void testArticleTagPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTagById() {
		fail("Not yet implemented");
	}

}
