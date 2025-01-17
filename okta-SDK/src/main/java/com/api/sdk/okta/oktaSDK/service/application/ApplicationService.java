package com.api.sdk.okta.oktaSDK.service.application;

import java.io.File;
import java.util.List;

import com.api.sdk.okta.oktaSDK.dto.application.AppGroup;
import com.api.sdk.okta.oktaSDK.dto.application.AppUser;
import com.api.sdk.okta.oktaSDK.dto.application.ApplicationResponse;
import com.api.sdk.okta.oktaSDK.dto.application.AssignUserToAppForSsoRequest;
import com.api.sdk.okta.oktaSDK.dto.application.BasicAuthAppRequest;
import com.api.sdk.okta.oktaSDK.dto.application.BookmarkAppRequest;
import com.api.sdk.okta.oktaSDK.dto.application.CustomSaml2AppRequest;
import com.api.sdk.okta.oktaSDK.dto.application.CustomSwaAppRequest;
import com.api.sdk.okta.oktaSDK.dto.application.OAuth2ClientAppRequest;
import com.api.sdk.okta.oktaSDK.dto.application.OktaOrg2OrgAppRequest;
import com.api.sdk.okta.oktaSDK.dto.application.PluginSwaAppRequest;
import com.api.sdk.okta.oktaSDK.dto.application.Saml2AuthAppRequest;
import com.api.sdk.okta.oktaSDK.dto.application.SwaAppRequest;
import com.api.sdk.okta.oktaSDK.dto.application.UpdateAppCredentialsForAssignedUserRequest;
import com.api.sdk.okta.oktaSDK.dto.application.WsFedAppRequest;
import com.api.sdk.okta.oktaSDK.dto.application.certificates.CertificateResponse;
import com.api.sdk.okta.oktaSDK.dto.application.certificates.CsrRequest;
import com.api.sdk.okta.oktaSDK.dto.application.certificates.CsrResponse;
import com.api.sdk.okta.oktaSDK.dto.application.certificates.SamlMetadata;
import com.api.sdk.okta.oktaSDK.dto.application.certificates.UpdateApplicationCertificate;
import com.api.sdk.okta.oktaSDK.dto.application.credentials.UpdatePluginAppCredentialsRequest;
import com.api.sdk.okta.oktaSDK.dto.application.oauth2.ScopeConsentGrant;
import com.api.sdk.okta.oktaSDK.dto.application.oauth2.ScopeConsentGrantRequest;
import com.api.sdk.okta.oktaSDK.dto.application.provisioning.ProvisioningRequest;
import com.api.sdk.okta.oktaSDK.dto.application.provisioning.ProvisioningResponse;

public interface ApplicationService {

	public ApplicationResponse addSaml2AuthAppInstance(Saml2AuthAppRequest request);

	public ApplicationResponse addCustomSaml2App(CustomSaml2AppRequest request);

	public ApplicationResponse addCustomSwaApp(CustomSwaAppRequest request);

	public ApplicationResponse addBasicAuthApp(BasicAuthAppRequest request);

	public ApplicationResponse addPluginSwaApp(PluginSwaAppRequest request);

	public ApplicationResponse addWsFedApp(WsFedAppRequest request);

	public ApplicationResponse addSwaApp(SwaAppRequest request);

	public ApplicationResponse addOAuth2ClientApp(OAuth2ClientAppRequest request);

	public ApplicationResponse addBookmarkApp(BookmarkAppRequest request);

	public ApplicationResponse addOktaOrg2OrgApp(OktaOrg2OrgAppRequest request);

	public CertificateResponse generateCertificate(String appId, int validityYears);

	public SamlMetadata previewSamlMetadata(String appId, String keyId);

	public CertificateResponse shareCloneCertificate(String appId, String keyId, String targetAid);

	public ApplicationResponse updateApplicationCertificate(String appId, UpdateApplicationCertificate request);

	public CertificateResponse getCertificate(String appId, String keyId);

	public List<CertificateResponse> listCertificates(String appId);

	public String generateCsrInPkcs10(String appId, CsrRequest request);

	public CsrResponse generateCsrInJson(String appId, CsrRequest request);

	public List<CsrResponse> listCsrs(String appId);

	public CsrResponse getCsr(String appId, String csrId);

	public String revokeCsr(String appId, String csrId);

	public ApplicationResponse updatePluginSWAToSharedCreds(String appId, UpdatePluginAppCredentialsRequest request);

	public ApplicationResponse updatePluginSWAToUserEditPassword(String appId,
			UpdatePluginAppCredentialsRequest request);

	public ApplicationResponse updatePluginSWAToOktaPassword(String appId, UpdatePluginAppCredentialsRequest request);

	public ApplicationResponse updatePluginSWAToUserEditUsernameAndPassword(String appId,
			UpdatePluginAppCredentialsRequest request);

	public ApplicationResponse updatePluginSWAToAdminSetsUsernameAndPassword(String appId,
			UpdatePluginAppCredentialsRequest request);

	public String deactivateApp(String appId);

	public String activateApp(String appId);

	public List<ScopeConsentGrant> listScopeConsentGrants(String appId);

	public ScopeConsentGrant getScopeConsentGrant(String appId, String grantId);

	public ScopeConsentGrant addScopeConsentGrant(String appId, ScopeConsentGrantRequest request);

	public String revokeScopeConsentGrant(String appId, String grantId);
	
	public String uploadLogo(String appId, File file);

	public ProvisioningResponse getDefaultProvisioningConnection(String appId);

	public ProvisioningResponse createDefaultProvisioningConnection(String appId, ProvisioningRequest request);

	public String activateDefaultProvisioningConnection(String appId);

	public String deactivateDefaultProvisioningConnection(String appId);

	public List<ApplicationResponse> listApps();

	public List<ApplicationResponse> filterApps(String filter);

	public ApplicationResponse getApp(String appId);

	public List<AppUser> listUsersAssignedToApp(String appId);

	public List<ApplicationResponse> filterAndExpandApps(String filter, String expand);

	public AppUser assignUserToAppForSso(String appId, AssignUserToAppForSsoRequest assignUserRequest);

	public AppUser getAssignedUserForApp(String appId, String userId);

	public AppUser updateAppCredentialsForAssignedUser(String appId, String userId,
			UpdateAppCredentialsForAssignedUserRequest request);
	
	public String deleteUserFromApp(String appId, String userId);
	
	public AppGroup assignGroupToApp(String appId, String groupId);
	
	public List<AppGroup> listAssignedGroups(String appId);
	
	public String removeGroupFromApp(String appId, String groupId);
	
	public String deleteApp(String appId);
}
