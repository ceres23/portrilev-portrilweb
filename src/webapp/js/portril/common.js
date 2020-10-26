/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
/**
 * Escapes an HTML string
 * @param unsafe the string to escape
 * @returns the escaped string
 */
function escapeHtml(unsafe) {
    if(unsafe === null || unsafe === undefined) {
        return '';
    }
	return unsafe
	     .replace(/&/g, '&amp;')
		 .replace(/</g, '&lt;')
		 .replace(/>/g, '&gt;')
		 .replace(/"/g, '&quot;')
		 .replace(/'/g, '&#039;');
 }

function xmlAttributeEscapeString(str) {
    return str
        .replace(/"/g, '\\"')
        .replace(/'/g, '\\\'');
}
