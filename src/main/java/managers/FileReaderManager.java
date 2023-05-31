package managers;

import dataProvider.ConfigFileReader;

/**
 * Singleton pattern
 *
 */
public class FileReaderManager {
    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    /**
     * Ensures no one can create another instance of a FileReader manager
     * need to use get instance to use other public methods
     */
    private FileReaderManager()
    {}

    /**
     *
     * @return reference to itself
     */
    public static FileReaderManager getInstance()
    {
        return fileReaderManager;
    }

    /**
     *
     * @return configFileReader object
     */
    public ConfigFileReader getConfigFileReader()
    {
        if(configFileReader == null)
        {
            return configFileReader = new ConfigFileReader();
        }
        else
        {
            return  configFileReader;
        }
    }



}
