<?php
$g_hostname				= 'localhost';

$g_db_username			= 'root';

$g_db_password			= '';

$g_database_name		= 'bugtracker';

$g_db_type				= 'mysqli';

$g_dsn = '';

$g_db_table_prefix = 'mantis';

$g_db_table_suffix = '_table';

$g_db_table_plugin_prefix	= 'plugin';

$g_absolute_path = dirname( __FILE__ ) . DIRECTORY_SEPARATOR;

$g_library_path = $g_absolute_path . 'library' . DIRECTORY_SEPARATOR;

$g_vendor_path = $g_absolute_path . 'vendor' . DIRECTORY_SEPARATOR;

$t_local_config = getenv( 'MANTIS_CONFIG_FOLDER' );
if( $t_local_config && is_dir( $t_local_config ) ) {
	$g_config_path = $t_local_config;
} else {
	$g_config_path = $g_absolute_path . 'config' . DIRECTORY_SEPARATOR;
}

unset( $t_local_config );

# Web Server #
##############

/**
 * Session save path.  If false, uses default value as set by session handler.
 * @global bool $g_session_save_path
 */
$g_session_save_path = false;

/**
 * Session validation
 * WARNING: Disabling this could be a potential security risk!!
 * @global integer $g_session_validation
 */
$g_session_validation = ON;

/**
 * Form security validation.
 * This protects against Cross-Site Request Forgery, but some proxy servers may
 * not correctly work with this option enabled because they cache pages
 * incorrectly.
 * WARNING: Disabling this is a security risk!!
 *
 * @global integer $g_form_security_validation
 */
$g_form_security_validation = ON;

#############################
# Security and Cryptography #
#############################

$g_crypto_master_salt = 'dfdsfdsfsdfsdfdsssssssssssssssssssssssssssssss';

$g_allow_signup			= ON;

$g_max_failed_login_count = OFF;

/**
 * access level required to be notified when a new user has been created using
 * the "signup form"
 * @global integer $g_notify_new_user_created_threshold_min
 */
$g_notify_new_user_created_threshold_min = ADMINISTRATOR;

$g_send_reset_password	= ON;

$g_signup_use_captcha	= OFF;


$g_system_font_folder	= '';

$g_phpMailer_method =   PHPMAILER_METHOD_SMTP;
$g_smtp_host = 'localhost';