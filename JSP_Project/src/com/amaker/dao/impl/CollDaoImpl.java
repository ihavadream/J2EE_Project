package com.amaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amaker.bean.CollectionBean;
import com.amaker.util.DBUtil;

public class CollDaoImpl implements CollDao{

	@Override
	public void save(CollectionBean bean) {
		String sql="insert into collectiontbl (name,url) values(?,?)";
		DBUtil util=new DBUtil();
		Connection conn=util.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, bean.getName());
			pst.setString(2, bean.getUrl());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close(conn);
		}
	}

	@Override
	public void update(CollectionBean bean) {
		String sql="update collectiontbl set name=?,url=? where id=?";
		DBUtil util=new DBUtil();
		Connection conn=util.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, bean.getName());
			pst.setString(2, bean.getUrl());
			pst.setInt(3, bean.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close(conn);
		}
	}

	@Override
	public void delete(String[] s) {
		String sql="delete from collectiontbl where id=?";
		DBUtil util=new DBUtil();
		Connection conn=util.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			if(s!=null&&s.length>0){
				for(int i=0;i<s.length;i++){
					int id=new Integer(s[i]).intValue();
					pst.setInt(1, id);
					pst.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.close(conn);
		}
	}

	@Override
	public List list() {
		String sql="select id,name,url from collectiontbl";
		DBUtil util=new DBUtil();
		Connection conn=util.getConnection();
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			List list=new ArrayList();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String url=rs.getString(3);
				CollectionBean bean=new CollectionBean();
				bean.setId(id);
				bean.setName(name);
				bean.setUrl(url);
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close(conn);
		}
		return null;
	}

	@Override
	public CollectionBean get(int id) {
		String sql="select id,name,url from collectiontbl where id=?";
		DBUtil util=new DBUtil();
		Connection conn=util.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				String name=rs.getString(2);
				String url=rs.getString(3);
				CollectionBean bean=new CollectionBean();
				bean.setId(id);
				bean.setName(name);
				bean.setUrl(url);
				return bean ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close(conn);
		}
		return null;
	}	

}
