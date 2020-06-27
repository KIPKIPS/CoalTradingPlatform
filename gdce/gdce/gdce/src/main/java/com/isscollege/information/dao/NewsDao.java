package com.isscollege.information.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.information.entity.News;
import com.isscollege.users.entity.Opinion;

@Mapper
public interface NewsDao {
	// 查询所有未审核的资讯
	@Select("select * from tb_news where nState = 0 order by nID desc")
	List<News> getAllNews();

	// 根据资讯编号查询对应的资讯
	@Select("select * from tb_news where nID = #{nID}")
	News getNewsById(Integer nID);

	// 修改对应资讯状态为通过，修改资讯审核人的编号
	@Update("update tb_news set nState = 1,nPublisherID = #{nPublisherID} where nID = #{nID}")
	Integer modifyPermitNews(@Param("nPublisherID") Integer nPublisherID, @Param("nID") Integer nID);

	// 资讯未通过时修改状态为待修改，修改审核人编号
	@Update("update tb_news set nState = 2,nPublisherID = #{nPublisherID} where nID = #{nID}")
	Integer modifyNotPermitNews(@Param("nPublisherID") Integer nPublisherID, @Param("nID") Integer nID);

	// 查询是否已存在对应资讯的意见
	@Select("SELECT COUNT(1) FROM tb_opinion WHERE uID = #{nID} AND oType = 4;")
	Integer getNewsOpinion(Integer nID);

	// 插入对应资讯资讯审核意见
	@Insert("insert into tb_opinion (uID,uOpinion,oType) value(#{nID},#{uOpinion},4)")
	Integer addNewsOpinion(@Param("nID") Integer nID, @Param("uOpinion") String uOpinion);

	// 修改对应资讯审核意见
	@Update("update tb_opinion set uOpinion = #{uOpinion} where uID = #{nID} and oType = 4")
	Integer modifyOpinion(@Param("nID") Integer nID, @Param("uOpinion") String uOpinion);

	// 插入新的资讯标题和资讯内容,审核人员编号默认为-1
	@Insert("insert into tb_news (nEditorID,nTheme,nContent,nPublisherID) values(#{nEditorID},#{nTheme},#{nContent},-1)")
	Integer addNews(@Param("nEditorID") Integer nEditorID, @Param("nTheme") String nTheme,
			@Param("nContent") String nContent);

	// 查询审核通过的资讯
	@Select("select * from tb_news where nState = 1 order by nID desc")
	List<News> getAllCheckedNews();

	// 查询审核未通过的资讯
	@Select("select * from tb_news where nState = 2 order by nID desc")
	List<News> getAllNoCheckedNews();

	// 查询对应资讯的审核意见
	@Select("select * from tb_opinion,tb_news where nID = #{nID} and nID = uID")
	Opinion getOpinion(Integer nID);
}
