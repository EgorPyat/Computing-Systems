import React, {useEffect, useState} from 'react';
import './App.css';
import {Api} from "./api/Api";
import {CsEntityDto} from "./api/computing-systems";

function App() {
  const [data, setData] = useState<CsEntityDto[]>([]);
  const [content, setContent] = useState<CsEntityDto>();

  useEffect( () => {
    Api.getCsEntityHierarchy().then(response => setData(response.data));
  }, [])

  const handleEntityClick = (entity: CsEntityDto) => {
    setContent(entity);
  };

  const handleInput = (e) => {

  };

  const renderHierarchy = (rootEntities: CsEntityDto[]) => {
    return (
        <ul key={Date.now()}>
          {rootEntities.map(entity => (
              <>
                <li key={entity.id} onClick={() => handleEntityClick(entity)}>{entity.name}</li>
                {renderHierarchy(entity.descendants)}
              </>
          ))}
        </ul>
    );
  };

  return (
    <div className="wrapper">
      <div className="header">Классификация вычислительных систем по</div>
      <div className="article">
        <div>
          <p>{content?.name}</p>
          <p>{content?.description}</p>
        </div>
      </div>
      <div className="aside">
        <label>
          Поиск:
          <input type="text" name="name" onChange={handleInput}/>
        </label>
        {renderHierarchy(data)}
      </div>
      <div className="footer">Пятаев Егор Евгеньевич, 19223. Вычислительные системы, 2020</div>
    </div>
  );
}

export default App;
