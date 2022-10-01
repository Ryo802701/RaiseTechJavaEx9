package com.example.ex9.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.ex9.entity.Calory;

@Mapper
public interface CaloryRepository {
	@Select("SELECT * FROM food_calory")
	List<Calory> findAll();

	@Select("SELECT * FROM food_calory WHERE id = #{id}")
	Optional<Calory> findById(int id);

	@Select("SELECT * FROM food_calory WHERE kcal BETWEEN #{kcal_from} AND #{kcal_to}")
	List<Calory> findByKcal(@Param("kcal_from") int kcal_from, @Param("kcal_to") int kcal_to);

	@Select("SELECT * FROM food_calory WHERE kind = #{kind} AND kcal BETWEEN #{kcal_from} AND #{kcal_to}")
	List<Calory> findByKindKcal(@Param("kind") String kind, @Param("kcal_from") int kcal_from,
			@Param("kcal_to") int kcal_to);

	@Insert("INSERT INTO food_calory (kind, menu, kcal) values (#{kind}, #{menu}, #{kcal})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void create(Calory calory);

	@Update("UPDATE food_calory SET kind = #{kind}, menu = #{menu}, kcal = #{kcal} WHERE id = #{id}")
	void update(Calory calory);

	@Delete("DELETE FROM food_calory WHERE id = #{id}")
	void delete(int id);

}
