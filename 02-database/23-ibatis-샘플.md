1. 모든 메인 카테고리 조회
	id 
		getMainCategories
	SQL
		select 
			cate_no as no, cate_name as name, cate_parent_no as parentNo
		from
			categories
		where cate_parent_no is null
	parameterClass
		정의할 필요없음
	resultClass
		demo.book.Category 	<--- 여러 개의 카테고리 정보가 조회됨
	실행방법
		public List<Category> getMainCategories() {
			List<Category> result = sqlMapClient.queryForList("getMainCategories");
			return result;
		}
		

2. 새로운 카테고리 등록
	id 
		addCategory
	SQL
		insert into tb_categories(cate_no, cate_name, cate_parent_no)
		values(cate_seq.nextval, #name#, #parentNo#)
	parameterClass
		demo.book.Category	<-- 쿼리실행에 필요한 값을 제공할 객체
	실행방법
		public void addCategory(Category c) {
			sqlMapClient.insert("addCategory", c);
		}

3. 카테고리 삭제하기
	id
		deleteCategoryByNo
	SQL	
		delete from tb_categories where cate_no = #value#
	parameterClass
		int
	실행방법
		public void deleteCategoryByNo(int cateNo) {
			sqlMapClient.delete("deleteCategoryByNo", cateNo)
		}

4. 카테고리 번호로 카테고리 정보 조회하기
	id
		getCategoryByNo
	SQL
		select
			cate_no as no, cate_name as name, cat_parent_no as parentNo
		from
			tb_categories
		where 
			cate_no = #value#
	parameterClass
		int
	resultClass
		demo.book.Category	<--- 한 개의 카테고리 정보가 조회됨
	실행방법
		public Category getCategoryByNo(int catNo) {
			Category result = (Category) sqlMapClient.queryForObject("getCategoryByNo", catNo);
			return result;
		}

5. 상위카테고리 번호로 하위카테고리 정보 조회하기
	id
		getSubCategoryByParentNo
	SQL
		select
			cat_no as no, cat_name as name, cat_parent_no as parentNo
		from
			tb_categories
		where
			cat_parent_no = #value#
	parameterClass
		int
	resultClass
		demo.book.Category	<--- 여러 개의 카테고리 정보가 조회됨
	실행방법
		public List<Category> getSubCategoryByParentNo(int parentNo) {
			return sqlMapClient.queryForList("getSubCategoryByParentNo", parentNo);
		}

6. 전달된 이름과 동일한 이름을 가진 카테고리가 있는지(몇개나 되는지) 조회하기
	id
		getCategoryCountByName
	SQL
		select 
			count(*)
		from
			tb_categories
		where
			cate_name = #value#
	parameterClass
		string
	resultClass
		int
	실행방법
		public int getCategoryCountByName(String catName) {
			return (Integer)sqlMapClient.queryForObject("getCategoryCountByName", catName);
		}
	
		
	
		
		
		














	












		
		
