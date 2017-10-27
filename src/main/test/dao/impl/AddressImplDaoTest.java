package dao.impl;

import dao.DaoException;
import entity.Address;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class AddressImplDaoTest {


    @Test
    public void testAdd() throws Exception {
        Address address = new Address(999L, "Test", "Test", "Test", "Test");
        AddressImplDao addressImplDao = new AddressImplDao();
        try {
            addressImplDao.add(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getId(), address.getId());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCountry(), address.getCountry());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getStreet(), address.getStreet());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getPostCode(), address.getPostCode());
            addressImplDao.remove(address);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        } finally {
            addressImplDao.close();
        }
    }

    @Test
    public void testGetAll() throws Exception {
        Address address = new Address(999L, "Test", "Test", "Test", "Test");
        AddressImplDao addressImplDao = new AddressImplDao();
        try {
            addressImplDao.add(address);
            List<Address> list = addressImplDao.getAll();
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size() > 0);
            addressImplDao.remove(address);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        } finally {
            addressImplDao.close();
        }
    }

    @Test
    public void testGetById() throws Exception {
        Address address = new Address(999L, "Test", "Test", "Test", "Test");
        AddressImplDao addressImplDao = new AddressImplDao();
        try {

            addressImplDao.add(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getId(), address.getId());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCountry(), address.getCountry());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getStreet(), address.getStreet());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getPostCode(), address.getPostCode());
            addressImplDao.remove(address);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        } finally {
            addressImplDao.close();
        }
    }

    @Test
    public void testUpdate() throws Exception {
        Address address = new Address(999L, "Test", "Test", "Test", "Test");

        AddressImplDao addressImplDao = new AddressImplDao();

        try {
            addressImplDao.add(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getId(), address.getId());
            address.setCity("New City");
            address.setCountry("New Country");
            address.setStreet("new Street");
            address.setPostCode("new PostCode");
            addressImplDao.update(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCountry(), address.getCountry());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getStreet(), address.getStreet());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getPostCode(), address.getPostCode());
            addressImplDao.remove(address);
        } catch (DaoException e) {
            e.printStackTrace();

            Assert.fail();
        } finally {
            addressImplDao.close();
        }
    }

    @Test
    public void testRemove() throws Exception {
        Address address = new Address(999L, "Test", "Test", "Test", "Test");
        AddressImplDao addressImplDao = new AddressImplDao();
        addressImplDao.add(address);
        Assert.assertNotNull(addressImplDao.getById(address.getId()).getId());
        addressImplDao.remove(address);
        try {
            Assert.assertNull(addressImplDao.getById(address.getId()).getId());
        } catch (DaoException d) {
            d.printStackTrace();
        } finally {
            addressImplDao.close();
        }

    }

}