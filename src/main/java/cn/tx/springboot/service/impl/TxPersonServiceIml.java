package cn.tx.springboot.service.impl;

import cn.tx.springboot.dao.TxPersonMapper;
import cn.tx.springboot.model.TxPerson;
import cn.tx.springboot.service.TxPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TxPersonServiceIml implements TxPersonService {

    @Autowired
    private TxPersonMapper personMapper;

    @Override
    public List<TxPerson> selectPersons() {
        return personMapper.selectPersons();
    }

    @Override
    public TxPerson getPeronById(int pid) {
        return personMapper.getPersonById(pid);
    }

    @Override
    public void updatePerson(TxPerson p) {
        personMapper.updatePerosn(p);
    }

    @Override
    public void insert(TxPerson p) {
        personMapper.insert(p);
    }

    @Override
    public void delete(int pid) {
        personMapper.delete(pid);
    }

    @Override
    public TxPerson getPersonByUserPass(Map<String, String> map) {
        return personMapper.getPersonByUserPass(map);
    }

    @Override
    public TxPerson getPeronByUsername(String username) {
        return personMapper.getPersonByUsername(username);
    }
}
