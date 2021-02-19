package chapter_10;

/**
 * SRP 原则的优点：
 *   1：类的复杂性降低了，由于我们让每个类的职责单一，因此每个类职责清楚，定义明确；
 *   2：可读性增强了，复杂性降低了，类更容易维护了；
 *   3：变更的风险降低了，需求一直处于变化，使用 SRP 原则只需要修改一个接口及其实现类，对其他类的接口，没有影响；
 *
 */
public interface IUserProcess {
    void addUser(int id ,String name,String password);

    void deleteUser(int id);

}
