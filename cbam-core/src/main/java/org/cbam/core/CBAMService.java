package org.cbam.core;

/**
 * Created by wuyaohui on 14-9-24.
 */

public interface CBAMService {


    /**
     * Is an AuthorizationEntity is allowed.
     * <p>
     *      Perl style pseudo code.
     *     <pre><code>
     *
     *      my @user_roles = ();
     *
     *      for my permission (permissions) {
     *
     *      }
     *      </code>
     *      </pre>
     * </p>
     *
     * @param entity
     * @return
     */
    public boolean isAllowed(AuthorizationEntity entity);

    /**
     * Is an AuthorizationEntity is not allowed.
     *
     * @param entity
     * @return
     */
    public boolean isNotAllowed(AuthorizationEntity entity);
}
