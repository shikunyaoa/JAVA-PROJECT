package com.kunyao.java.design_patterns.facade;

/**
 * @ClassName: Facade
 * @Author: kunyao
 * @Description: 外观模式：为子系统中的一组接口提供一个一致的界面。Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 * @PersonDesc: 在一个对外暴露的接口中调用多个实际提供服务的接口，类似于服务层
 * @Date: 2020/4/7 10:58
 * @Version: 1.0
 */
public class Facade {
    public Company openCompany(String name) {
        AdminOfIndustry admin = new AdminOfIndustry();
        Bank bank = new Bank();
        Taxation taxation = new Taxation();
        Company c = admin.register(name);
        String bankAccount = bank.openAccount(c.getId());
        c.setBankAccount(bankAccount);
        String taxCode = taxation.applyTaxCode(c.getId());
        c.setTaxCode(taxCode);
        return c;
    }
}

class Company{
    private String BankAccount;
    private String TaxCode;
    private String Id;

    public void setBankAccount(String bankAccount) {
    }

    public void setTaxCode(String taxCode) {
    }

    public String getId() {
        return "";
    }
}

class AdminOfIndustry {
    public Company register(String name) {
        return new Company();
    }
}

// 银行开户:
 class Bank {
    public String openAccount(String companyId) {
        return null;
    }
}

// 纳税登记:
 class Taxation {
    public String applyTaxCode(String companyId) {
       return null;
    }
}