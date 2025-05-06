package mylab.customer.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import mylab.customer.vo.CustomerVO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "mylab.customer.dao.mapper.CustomerMapper";

    @Override
    public CustomerVO selectCustomer(int id) {
        return sqlSession.selectOne(NAMESPACE + ".selectCustomer", id);
    }

    @Override
    public List<CustomerVO> selectAllCustomer() {
        return sqlSession.selectList(NAMESPACE + ".selectAllCustomer");
    }

    @Override
    public void insertCustomer(CustomerVO customer) {
        sqlSession.insert(NAMESPACE + ".insertCustomer", customer);
    }
}
