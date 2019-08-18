package com.yang.designpattern.actionpattern.chainofrespon;

import lombok.Data;

/**
 * @author: Yang
 * @date: 2019/8/17 11:03
 * @description: <p>
 * 定义：将能够处理同一类请求的对象串成一条链，所提交的请求沿着链传递，链上的对象逐个判断是否有能力处理该请求，如果能则处理，不能则传递给下一个对象。
 * <p>
 * 实现：链表式、数组式。
 * <p>
 * 场景：分级流程审批、Spring-Security的认证授权流程、servlet过滤器链、一个try包含多个catch块、js中冒泡和捕获机制、Strust2的拦截器。
 * <p>
 * 优点：相对于if-else和switch-case语句，责任链中各节点的组织更灵活，面对逻辑变动或扩展时避免对原逻辑的修改，符合开闭原则。
 * 同时，面对复杂逻辑时避免了if-else这类语句过于庞大，更好维护。
 * <p>
 * 缺点：效率比原生if-else和switch-case低。
 * <p>
 * 例子：请假条审批，不同请假天数只能由不同级别领导的审批（双向链表）。
 * 首先：对于已有的节点类可以使用配置式的组织编排。
 * 其次：当需求有变，需要添加新的处理逻辑时，只需要编写新的节点类，然后将节点加到链上，不需要修改旧逻辑。
 */
public class ChainOfResponse {

    /**
     * 链表式
     */
    /*public static void main(String[] args) {
        Leader leader1 = new OneDayLeader("One");
        Leader leader2 = new TwoDayLeader("Two");
        Leader leader3 = new ThreeDayLeader("Three");
        Leader leader4 = new FourDayLeader("Four");
        Leader leader5 = new FiveDayLeader("Five");

        leader1.addAfter(leader2);
        leader2.addAfter(leader4);
        leader4.addBefore(leader3);
        leader2.addBefore(leader5);

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployeeName("yang");
        leaveRequest.setLeaveDay(5);
        leaveRequest.setReason("耍年假！");

        leader1.handle(leaveRequest);
    }*/

    /**
     * 数组式，更高效
     *
     * @param args
     */
    public static void main(String[] args) {
        Leader leader1 = new OneDayLeader("One");
        Leader leader2 = new TwoDayLeader("Two");
        Leader leader3 = new ThreeDayLeader("Three");
        Leader leader4 = new FourDayLeader("Four");
        Leader leader5 = new FiveDayLeader("Five");

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployeeName("yang");
        leaveRequest.setLeaveDay(3);
        leaveRequest.setReason("耍年假！");

        Leader[] leaderArr = {leader1, leader2, leader3, leader4, leader5};
        for (Leader leader : leaderArr) {
            if (leader.handle(leaveRequest)) {
                break;
            }
        }
    }

}

/**
 * 请假申请类
 */
@Data
class LeaveRequest {

    private String employeeName;

    private int leaveDay;

    private String reason;

}

/**
 * 领导抽象类
 */
@Data
abstract class Leader {

    protected String name;

    protected Leader before;

    protected Leader after;

    /*Leader() {
    }*/

    public Leader(String name) {
        this.name = name;
    }

    abstract public boolean handle(LeaveRequest request);

    public void addBefore(Leader leader) {
        assert leader != null;
        Leader before = this.before;
        if (before == null) {
            this.before = leader;
            leader.after = this;
        } else {
            before.after = leader;
            leader.before = before;
            this.before = leader;
            leader.after = this;
        }
    }

    public void addAfter(Leader leader) {
        assert leader != null;
        Leader after = this.after;
        if (after == null) {
            this.after = leader;
            leader.before = this;
        } else {
            leader.after = after;
            after.before = leader;
            this.after = leader;
            leader.before = this;
        }
    }

}

/**
 * 能处理一天
 */
@Data
class OneDayLeader extends Leader {

    OneDayLeader(String name) {
        super(name);
    }

    @Override
    public boolean handle(LeaveRequest request) {
        System.err.println("========我是：" + super.getName());
        if (request.getLeaveDay() == 1) {
            System.out.println("雇员：" + request.getEmployeeName() + "由于:" + request.getReason() + "请假：" + request.getLeaveDay() + "天");
            return true;
        } else {
            Leader next = super.after;
            if (next != null) {
                return next.handle(request);
            } else {
                System.err.println("无法批准！");
                return false;
            }
        }
    }
}


/**
 * 能处理两天
 */
@Data
class TwoDayLeader extends Leader {

    TwoDayLeader(String name) {
        super(name);
    }

    @Override
    public boolean handle(LeaveRequest request) {
        System.err.println("========我是：" + super.getName());
        if (request.getLeaveDay() == 2) {
            System.out.println("雇员：" + request.getEmployeeName() + "由于:" + request.getReason() + "请假：" + request.getLeaveDay() + "天");
            return true;
        } else {
            Leader next = super.after;
            if (next != null) {
                return next.handle(request);
            } else {
                System.err.println("无法批准！");
                return false;
            }
        }
    }
}

/**
 * 能处理三天
 */
@Data
class ThreeDayLeader extends Leader {

    ThreeDayLeader(String name) {
        super(name);
    }

    @Override
    public boolean handle(LeaveRequest request) {
        System.err.println("========我是：" + super.getName());
        if (request.getLeaveDay() == 3) {
            System.out.println("雇员：" + request.getEmployeeName() + "由于:" + request.getReason() + "请假：" + request.getLeaveDay() + "天");
            return true;
        } else {
            Leader next = super.after;
            if (next != null) {
                return next.handle(request);
            } else {
                System.err.println("无法批准！");
                return false;
            }
        }
    }
}

/**
 * 能处理四天
 */
@Data
class FourDayLeader extends Leader {

    FourDayLeader(String name) {
        super(name);
    }

    @Override
    public boolean handle(LeaveRequest request) {
        System.err.println("========我是：" + super.getName());
        if (request.getLeaveDay() == 4) {
            System.out.println("雇员：" + request.getEmployeeName() + "由于:" + request.getReason() + "请假：" + request.getLeaveDay() + "天");
            return true;
        } else {
            Leader next = super.after;
            if (next != null) {
                return next.handle(request);
            } else {
                System.err.println("无法批准！");
                return false;
            }
        }
    }
}

/**
 * 能处理五天
 */
@Data
class FiveDayLeader extends Leader {

    FiveDayLeader(String name) {
        super(name);
    }

    @Override
    public boolean handle(LeaveRequest request) {
        System.err.println("========我是：" + super.getName());
        if (request.getLeaveDay() == 5) {
            System.out.println("雇员：" + request.getEmployeeName() + "由于:" + request.getReason() + "请假：" + request.getLeaveDay() + "天");
            return true;
        } else {
            Leader next = super.after;
            if (next != null) {
                return next.handle(request);
            } else {
                System.err.println("无法批准！");
                return false;
            }
        }
    }
}
