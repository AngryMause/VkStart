package ua.kek.dobriy_kot.startvk.common.manager;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;

import java.util.Stack;

import ua.kek.dobriy_kot.startvk.ui.activity.BaseActivity;
import ua.kek.dobriy_kot.startvk.ui.fragmnet.BaseFragment;


public class MyFragmentManager {

    private static final int EMPTY_FRAGMENT_STACK = 1;

    private Stack<BaseFragment> myFragmentStack = new Stack<>();

    private BaseFragment currentFragment;

    public void setFragment(BaseActivity activity,BaseFragment fragment,@IdRes int containerId){
        if (activity!=null&& !activity.isFinishing() && !isAlreadyContains(fragment)){
            FragmentTransaction transaction=createAddTransaction(activity,fragment,false);
            transaction.replace(containerId,fragment);
            commitAddTransaction(activity,fragment,transaction,false);
        }
    }

    public void addFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId){
        if (activity!=null &&!activity.isFinishing() && !isAlreadyContains(fragment) ){
            FragmentTransaction fragmentTransaction=createAddTransaction(activity,fragment,true);
            fragmentTransaction.add(containerId,fragment);
            commitAddTransaction(activity,fragment,fragmentTransaction,true);
        }

    }

    public boolean removeCurrentFragment(BaseActivity baseActivity){
        return removeFragment(baseActivity,currentFragment);
    }
    public boolean removeFragment(BaseActivity baseActivity, BaseFragment baseFragment){
        boolean canRemove=baseFragment!=null && myFragmentStack.size()>EMPTY_FRAGMENT_STACK;
        if (canRemove){
            FragmentTransaction transaction=baseActivity.getSupportFragmentManager().beginTransaction();
            myFragmentStack.pop();
            currentFragment=myFragmentStack.lastElement();

            transaction.remove(baseFragment);
            commitTransaction(baseActivity,transaction);
        }

        return canRemove;
    }

    private FragmentTransaction createAddTransaction(BaseActivity activity,BaseFragment fragment
            ,boolean addToBackStack){
        FragmentTransaction fragmentTransaction=activity.getSupportFragmentManager().beginTransaction();
        if (addToBackStack){
            fragmentTransaction.addToBackStack(fragment.getTag());
        }
        return fragmentTransaction;
    }
    private void commitAddTransaction(BaseActivity activity,BaseFragment fragment,FragmentTransaction transaction,boolean addToBackStack){
        if (transaction!=null){
            currentFragment=fragment;
            if (!addToBackStack) {
                myFragmentStack = new Stack<>();
            }
            myFragmentStack.add(fragment);
            commitTransaction(activity,transaction);
        }

    }

    private void commitTransaction(BaseActivity activity, FragmentTransaction transaction) {
        transaction.commit();
        activity.fragmentOnScreen(currentFragment);
    }
    public boolean isAlreadyContains(BaseFragment fragment){
        if (fragment==null){
            return false;
        }
        return currentFragment!=null && currentFragment.getClass().getName().equals(fragment.getClass().getName());
    }
    public Stack<BaseFragment> getFragmentStack(){
        return myFragmentStack;
    }

}
