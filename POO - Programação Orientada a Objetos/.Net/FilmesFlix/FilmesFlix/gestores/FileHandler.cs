using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.gestores
{
    using FilmesFlix.utilizadores;
    using System;
    using System.IO;
    using System.Runtime.Serialization.Formatters.Binary;
    using System.Text.Json;

    public class FileHandler
    {
        public static void Save(string path, object data)
        {
            if (data == null)
            {
                throw new ArgumentNullException(nameof(data), "O objeto a ser salvo não pode ser nulo.");
            }

            string jsonString = JsonSerializer.Serialize(data);
            File.WriteAllText(path, jsonString);
        }

        public static string Load(string path)
        {
            if (!File.Exists(path)) throw new FileNotFoundException("Ficheiro não encontrado.", path);

            string jsonString = File.ReadAllText(path);
            return jsonString;
        }
    }
}

