package cyou.bike.com.live.repository.daggerProvider;

import cyou.bike.com.live.repository.remoterepository.Remote;


/**
 * 作者：anlonglong on 2017/10/3 13:24
 */

//@Component(modules = RepositoryModule.class)
public interface RepositoryComponent {

    void inject(Remote remote);
}
