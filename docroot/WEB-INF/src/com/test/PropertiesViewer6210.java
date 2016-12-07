// Working version - the properties are shown correctly.
// Still need to test if all the properties appear in the results.
// One other thing: instead of the ownerId, I had to use the companyId,
// The official documentation mentions ownerId but I believe the companyId has to be used.

package com.test;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.PortalPreferences;
//import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.PortalPreferencesLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

/**
 * Portlet implementation class PropertiesViewer6210
 */
public class PropertiesViewer6210 extends MVCPortlet {
 
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		System.out.println("* ProcessAction starts.. *");
		
//		int actualPrefsCount = 0;
//		List<PortalPreferences> actualPrefs = null;
//		try {
//			actualPrefsCount = PortalPreferencesLocalServiceUtil.getPortalPreferencesesCount();
//			actualPrefs = PortalPreferencesLocalServiceUtil.getPortalPreferenceses(0, actualPrefsCount);
//		} catch (SystemException e) {
//			e.printStackTrace();
//		}
//		for(PortalPreferences actualPref : actualPrefs){
//			System.out.println(actualPref);
//		}
//		System.out.println("********************");
		
		long companyId = PortalUtil.getDefaultCompanyId();
//		long ownerId = 20155;
//		long ownerId = PortletKeys.PREFS_OWNER_ID_DEFAULT;
		int ownerType = PortletKeys.PREFS_OWNER_TYPE_COMPANY;
//		System.out.println(ownerId + "and " + ownerType);
		PortletPreferences prefs = null ;
		try {
			prefs = PortalPreferencesLocalServiceUtil.getPreferences(companyId, ownerType);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		Enumeration<String> mynames = prefs.getNames();
		
		while(mynames.hasMoreElements()){
	        System.out.println(mynames.nextElement());
	    }
		
		System.out.println("* ProcessAction ends.. *");
		}

}
