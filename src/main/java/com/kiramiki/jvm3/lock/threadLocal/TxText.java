//package com.kiramiki.jvm3.lock.threadLocal;
//
///**
// * @ Author ：zyw.
// * @ Date ：Created in 10:26 2022/7/25
// * @ Description ：spring事务
// */
//public class TxText {
//    protected Object invokeWithinTransaction(Method method, @Nullable Class<?> targetClass,
//                                             final InvocationCallback invocation) throws Throwable {
//
//        //注入的transactionAttributeSource
//        TransactionAttributeSource tas = getTransactionAttributeSource();
//        //####1.获取解析时缓存的TransactionAttribute，里面存有事务注解的属性值
//        final TransactionAttribute txAttr = (tas != null ? tas.getTransactionAttribute(method, targetClass) : null);
//        //####2.获取具体的PlatformTransactionManager
//        //(1).如果txAttr为null或者beanFactory为null，返回注入的TransactionManager
//        //(2).如果txAttr.getQualifier不为null(即Transactional注解的value属性值)，则从beanFactory获取配置的bean返回
//        //(3).如果注入了transactionManagerBeanName则从beanFactory获取bean返回
//        //(4).如果没注入TransactionManager，就从beanFactory获取class为PlatformTransactionManager的bean返回
//        final PlatformTransactionManager tm = determineTransactionManager(txAttr);
//        //格式为com.alibaba.fastjson.JSONObject.getJSONArray
//        final String joinpointIdentification = methodIdentification(method, targetClass, txAttr);
//
//        //大部分情况都是走这
//        if (txAttr == null || !(tm instanceof CallbackPreferringPlatformTransactionManager)) {
//            //进行标准事务流程，先获取事务，再执行原始方法，最后commit/rollback
//            //把事务相关的类用TransactionInfo类存放
//            //调用tm.getTransaction(txAttr)获取TransactionStatus，再调用prepareTransactionInfo方法，new一个TransactionInfo，把这些参数和status都设置进去，再绑定到线程上（先get并设置到TransactionInfo的oldTransactionInfo属性上）
//            //####3.这里就是之前说的前置增强方法
//            TransactionInfo txInfo = createTransactionIfNecessary(tm, txAttr, joinpointIdentification);
//
//            Object retVal;
//            try {
//                //####4。回调，即执行拦截的method，如果还有别的切面，继续
//                retVal = invocation.proceedWithInvocation();
//            }
//            catch (Throwable ex) {
//
//                //####5.异常处理：如果txInfo的transactionAttribute不为null，且ex为rollback设置的异常（含子类），则调用txInfo的TransactionManager的rollback方法，否则调用commit方法
//                completeTransactionAfterThrowing(txInfo, ex);
//                throw ex;
//            }
//            finally {
//                //####7.清理线程绑定事务：transactionInfoHolder.set(this.oldTransactionInfo);把旧事务详情设置回线程
//                cleanupTransactionInfo(txInfo);
//            }
//            //#####6.提交事务
//            //如果txInfo.getTransactionStatus不为null，调用TransactionManager的commit
//            commitTransactionAfterReturning(txInfo);
//            return retVal;
//        }
//        //编程式事务，忽略
//    }
//}
