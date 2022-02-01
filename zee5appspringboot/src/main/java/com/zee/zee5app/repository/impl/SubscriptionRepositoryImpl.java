package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SubscriptionRepository;

@Repository
public class SubscriptionRepositoryImpl implements SubscriptionRepository {
	
	@Autowired
	DataSource dataSource;

	SubscriptionRepositoryImpl() throws IOException {

	}

	@Override
	public String addSubscription(Subscription subscription) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into subscription values(?,?,?,?,?,?,?,?,?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, subscription.getId());
			preparedStatement.setString(2, subscription.getDOP());
			preparedStatement.setString(3, subscription.getExpiryDate());
			preparedStatement.setLong(4, subscription.getSubscripAmount());
			preparedStatement.setString(5, subscription.getPaymentMode());
			preparedStatement.setString(6, subscription.getStatus());
			preparedStatement.setString(7, subscription.getType());
			preparedStatement.setString(8, subscription.getAutoRenewal());
			preparedStatement.setString(9, subscription.getRegId());
			System.out.println("here");
			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				return "fail";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";

	}

	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteStatement = "delete from subscription where regId=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
	}

	public Optional<ArrayList<Subscription>> getAllSubscriptions()
			throws InvalidIdLengthException, InvalidAmountException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Subscription> arrayList = new ArrayList<>();
		String selectStatement = "select * from subscription";

		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Subscription subscription = new Subscription();
				subscription.setId(resultSet.getString("id"));
				subscription.setAutoRenewal(resultSet.getString("autoRenewal"));
				subscription.setDOP(resultSet.getString("DOP"));
				subscription.setExpiryDate(resultSet.getString("expiryDate"));
				subscription.setRegId(resultSet.getString("regId"));
				subscription.setPaymentMode(resultSet.getString("paymentMode"));
				subscription.setStatus(resultSet.getString("status"));
				subscription.setSubscripAmount(resultSet.getInt("subscripAmount"));
				subscription.setType(resultSet.getString("type"));
				arrayList.add(subscription);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.ofNullable(arrayList);
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id)
			throws InvalidAmountException, InvalidIdLengthException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from subscription where regId=?";

		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Subscription subscription = new Subscription();
				subscription.setId(resultSet.getString("id"));
				subscription.setAutoRenewal(resultSet.getString("autoRenewal"));
				subscription.setDOP(resultSet.getString("DOP"));
				subscription.setExpiryDate(resultSet.getString("expiryDate"));
				subscription.setRegId(resultSet.getString("regId"));
				subscription.setPaymentMode(resultSet.getString("paymentMode"));
				subscription.setStatus(resultSet.getString("status"));
				subscription.setSubscripAmount(resultSet.getInt("subscripAmount"));
				subscription.setType(resultSet.getString("type"));
				return Optional.of(subscription);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.empty();

	}

	@Override
	public Optional<Subscription> updateSubscription(String id, Subscription subscription)
			throws IdNotFoundException, InvalidIdLengthException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateStatement = "update subscription set id=? , DOP = ?, expiryDate =?, subscripAMount=?, paymentMode=?, status=?, type=?, autoRenewal=?, regId=? where (regId=?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, subscription.getId());
			preparedStatement.setString(2, subscription.getDOP());
			preparedStatement.setString(3, subscription.getExpiryDate());
			preparedStatement.setLong(4, subscription.getSubscripAmount());
			preparedStatement.setString(5, subscription.getPaymentMode());
			preparedStatement.setString(6, subscription.getStatus());
			preparedStatement.setString(7, subscription.getType());
			preparedStatement.setString(8, subscription.getAutoRenewal());
			preparedStatement.setString(9, subscription.getRegId());
			preparedStatement.setString(10, id);
			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return Optional.of(subscription);
			} else {
				return Optional.ofNullable(subscription);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

}
//(id,DOP,expiryDate,subscripAmount,paymentMode,status,type,autoRenewal,regId)